package com.spring.part3.mvc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;
import com.spring.part3.mvc.domain.Book;
import com.spring.part3.mvc.service.BookService;
import com.spring.part3.mvc.web.util.BookGrid;
import com.spring.part3.mvc.web.util.Message;
import com.spring.part3.mvc.web.util.UrlUtil;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/books")
@Controller
public class BookController {
	
	private final Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookService bookService;
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        logger.info("Listing books");
        System.out.println("Listing Books:");
        

        List<Book> books = bookService.findAll();
        uiModel.addAttribute("books", books);

        logger.info("No. of books: " + books.size());

        return "books/list";
    }
    
    @ResponseBody
    @RequestMapping(value = "/listgrid", method = RequestMethod.GET, produces="application/json")
    public BookGrid listGrid(@RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "rows", required = false) Integer rows,
                                @RequestParam(value = "sidx", required = false) String sortBy,
                                @RequestParam(value = "sord", required = false) String order) {

        logger.info("Listing books for grid with page: {}, rows: {}", page, rows);
        logger.info("Listing books for grid with sort: {}, order: {}", sortBy, order);

        // Process order by
        Sort sort = null;
        String orderBy = sortBy;
        

        if (orderBy != null && order != null) {
            if (order.equals("desc")) {
                sort = new Sort(Sort.Direction.DESC, orderBy);
            } else
                sort = new Sort(Sort.Direction.ASC, orderBy);
        }

        // Constructs page request for current page
        // Note: page number for Spring Data JPA starts with 0, while jqGrid starts with 1
        PageRequest pageRequest = null;

        if (sort != null) {
            pageRequest = PageRequest.of(page - 1, rows, sort);
        } else {
            pageRequest = PageRequest.of(page - 1, rows);
        }

        Page<Book> bookPage = bookService.findAllByPage(pageRequest);

        

        // Construct the grid data that will return as JSON data
        BookGrid bookGrid = new BookGrid();

        bookGrid.setCurrentPage(bookPage.getNumber() + 1);
        bookGrid.setTotalPages(bookPage.getTotalPages());
        bookGrid.setTotalRecords(bookPage.getTotalElements());

        bookGrid.setBookData(Lists.newArrayList(bookPage.iterator()));

        return bookGrid;
    }
 
    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

}

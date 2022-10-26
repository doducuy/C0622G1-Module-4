package com.demo.controller;

import com.demo.model.Book;
import com.demo.model.OderBook;
import com.demo.service.IBookService;
import com.demo.service.IOderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class OderBookController {
    @Autowired
    IBookService iBookService;
    @Autowired
    IOderBookService iOderBookService;
    @GetMapping("/listBook")
    public String showListBook(Model model){
        model.addAttribute("bookList",iBookService.findAll());
        return "/listBook";
    }
    @GetMapping("/{id}/bookDetail")
    public String showFormOder(@PathVariable(value = "id") int id, Model model){
//        model.addAttribute("orderBook", new OderBook());
        model.addAttribute("book",iBookService.findById(id));
        return "/bookDetail";
    }
    @PostMapping("/saveOder")
    public String saveOder(@ModelAttribute (value = "book") Book book,RedirectAttributes redirectAttributes){
        OderBook oderBook = new OderBook();
        long bookRentalCode = (long) (Math.random()*(99999 - 10000)+10000);
        oderBook.setBookRentalCode(bookRentalCode);
        oderBook.setBook(book);
        iOderBookService.saveOder(oderBook);
        int quantity = book.getQuantity()-1;
        book.setQuantity(quantity);
        iBookService.saveBook(book);
        redirectAttributes.addFlashAttribute("mess","Oder Success!!!");
        return "redirect:/listBook";
    }
}

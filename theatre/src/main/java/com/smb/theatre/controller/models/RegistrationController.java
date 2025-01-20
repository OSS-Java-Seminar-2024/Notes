package com.smb.theatre.controller.models;

import com.smb.theatre.dto.UserDto;
import com.smb.theatre.exception.UserAlreadyExistsException;
import com.smb.theatre.model.User;
import com.smb.theatre.service.interfaces.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private IUserService IUserService;

    @GetMapping
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDto userDto,
            HttpServletRequest request,
            Errors errors) {

        ModelAndView mav = new ModelAndView();

        try {
            User registered = IUserService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistsException uaeEx) {
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        }

        return new ModelAndView("successRegister", "user", userDto);
    }
}

package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Member;
import org.softwire.training.bookish.models.page.MemberPageModel;
import org.softwire.training.bookish.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


    @Controller
    @RequestMapping("/members")
    public class MemberController {

        private final MemberService memberService;

       @Autowired
       public MemberController(MemberService memberService){
           this.memberService = memberService;
       }

       @RequestMapping("")
        ModelAndView members(){

           List<Member> allMembers = memberService.getAllMembers();
           MemberPageModel memberPageModel = new MemberPageModel();
           memberPageModel.setMembers(allMembers);

           return new ModelAndView("member", "model", memberPageModel);
       }
       @RequestMapping("/add-member")
        RedirectView addMember(@ModelAttribute Member member) {

           memberService.addMember(member);

           return new RedirectView("/members");
    }

    @RequestMapping("/delete-member")
        RedirectView deleteMember(@RequestParam int userId){

           memberService.deleteMember(userId);

           return new RedirectView("/members");
    }

    @RequestMapping("/edit-member")
        ModelAndView editMember(@RequestParam int userId){

           //memberService.editMember(userId);

        return new ModelAndView("memberedit", "model", userId);
    }
    @RequestMapping("/confirm-edit")
        RedirectView confirmEdit(@ModelAttribute Member member){

           memberService.editMember(member);
           return new RedirectView("/members");
    }
}

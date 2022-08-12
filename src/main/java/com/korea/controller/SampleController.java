package com.korea.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.korea.domain.SampleDTO;
import com.korea.domain.SampleDTOList;
import com.korea.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@RequestMapping("")
	public void sample1() {
		log.info("Sample Page Test...!!!");
	}
	
	@GetMapping("/sample2")
	public void sample2() {
		log.info("Sample2 Page Test...!!!");
	}
	
	@GetMapping("/sample3")
	public String sample3 (SampleDTO dto) {
		log.info("Sample3 Page Test...!!!!");
		log.info("dto's toString = " + dto.toString());
		return "sample3.html";
	}
	
	@GetMapping("/sample4")
	public String sample4(@RequestParam("name") String name, @RequestParam("age") Integer age) {
		log.info("심플3 페이지 테스트...!!!!");
		log.info("이름 타입 : " + name.getClass().getName());
		log.info("이름 타입 : " + age.getClass().getName());
		return "sample3.html";
	}
	
	@GetMapping("/sample5")
	public String sample5 (@RequestParam("n1") Integer n1, @RequestParam("n2") Integer n2) {
		log.info("샘플5 페이지 테스트...!!!!");
		log.info("합은 : " + (n1 + n2) );
		
		return "sample5.html";
	}
	
	@GetMapping("/sample6")
	public void sample6(@RequestParam("num") ArrayList<Integer> list) {
		log.info("샘플6 페이지 테스트...!!!!");
		for(int i = 0; i < list.size(); i++) {
			log.info("num[" + i + "] = " + list.get(i));
		}
	}
	
	@GetMapping("/sample7")
	public void sample7(@RequestParam("num") Integer[] list) {
		log.info("샘플7 페이지 테스트...!!!!");
		for(int i = 0; i < list.length; i++) {
			log.info("num[" + i + "] = " + list[i]);
		}
	}
	
	@GetMapping("/sample8")
	public void sample8(SampleDTOList list) {
		log.info("Sample8 Page Test...!!!!");
		
		for(SampleDTO dto : list.getList()) {
			log.info(dto.toString());
		}
	}
	
//		@InitBinder
//		public void initBinder (WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class,new CustomDateEditor(df, false));
//		}
	
	@GetMapping("/sample9")
	public void sample9(TodoDTO todo) {
		log.info("Sample9 Page Test...!!!");
		//log.info("TodoDTO = " + dto.toString());
		
		log.info(todo.toString());
		
	}
	
	@GetMapping("/forwardtest")
	public String forwardfunc(Model model) {
		
		log.info("-----------forwardtest Page Test...!!!! ---------------");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("보근이-Forward");
		dto.setAge(27);
		int page=11;
		
		model.addAttribute("dto",dto);
		model.addAttribute("page", + page);
		
		return "forward:result";
	}
	
		@GetMapping("/result")
		public String resultfunc(Model model) {
			
			log.info("------------ result(GET) Page Test...!!!!! --------");
			model.addAttribute("rval","Rvalue!");
			
			return "/sample/result";
					
	}
		
		@GetMapping("/redirecttest")
		public String redirectfunc(RedirectAttributes rttr) {
			
			log.info("--------------redirecttest Page Test...!!!!-------------");
			
			SampleDTO dto = new SampleDTO();
			dto.setName("홍길동-Redirect");
			dto.setAge(34);
			Integer page=11;
			
			//리타이렉트 객체 저장
			rttr.addFlashAttribute("dto",dto);
			rttr.addFlashAttribute("page",page);
			
			log.info("redirect's dto : " + dto.toString());
			log.info("redirct's page : " + page);
			
			return "rediret:result";
		}
		
		@GetMapping("/voidtest")
		public void testfunc() {
			log.info("void est Page!!----");
		}
	
		@GetMapping("/stringtest")
		public String testfunc2(@RequestParam("Page") Integer page) {
			log.info("String test Page !!---");
			
			if(page==1) {
				return "/sample/one";
				
			}else {
				return "/sample/two";
			}
		}
		
		@GetMapping("/objectTest")
		public @ResponseBody SampleDTO testfunc3() {
			SampleDTO dto = new SampleDTO();
			dto.setAge(10);
			dto.setName("길동이");
			
			return dto;
		}
		
		@GetMapping("/responseEntityTest")
		public ResponseEntity<String> testfunc4(){
			
			String msg = "{\"name\" : \"홍길동\",\"age\" : \"55\" }";
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type","application/json;charset=UTF-8");
			return new ResponseEntity<>(msg,header,HttpStatus.OK);
		}
		
		@GetMapping("/errorTest")
		public String errortestFunc(SampleDTO dto,Model model) {
			
			model.addAttribute("dto",dto);
			return "/sample/main";
		}
		
		@GetMapping("/UploadTest")
		public String uploadFunc() {
			log.info("upload 혜지 page....");
			return "upform";
		}
		
		@PostMapping("/post.do")
		public void upload(ArrayList<MultipartFile> files) {
			files.forEach(file->{
				log.info("---------------------------------");
				log.info("name : " + file.getOriginalFilename());
				log.info("size : " + file.getSize());
			});
		}
}

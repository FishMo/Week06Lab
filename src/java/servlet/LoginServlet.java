/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import business.UserService;
import business.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.CookieUtil;



/**
 *
 * @author 709317
 */
public class LoginServlet extends HttpServlet {

    UserService us = new UserService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = CookieUtil.getCookieValue(request.getCookies(), "userCookie");
        
        if (username != null && !username.equals("")) {

                request.setAttribute("username", username);
                request.setAttribute("checked", "checked");                
         }  
        
        if(action != null && action.equals("logout"))
        {
            session.removeAttribute("username");
            session.invalidate();
            request.setAttribute("message", "You have successfully loged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        if(session.getAttribute("username") != null && action == null)
        {
           //getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            response.sendRedirect("Home");
            return;
        }
        

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
      
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String message = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");   
        
        if(username!=null&&password!=null||!username.isEmpty()&&!password.isEmpty())
        {
           
            UserService us = new UserService();
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            
            if(us.login(user) !=null){
                
                session.setAttribute("username", user.getUsername());
                session.setMaxInactiveInterval(60);
                
                Cookie usernameCookie = new Cookie("userCookie", user.getUsername());
                
                if(request.getParameter("remember")!=null){
                    usernameCookie.setMaxAge(60*60*24);
                    usernameCookie.setPath("/");
                    response.addCookie(usernameCookie);
                }
                else {
              //     if(usernameCookie != null){
                        usernameCookie.setMaxAge(0);
                        usernameCookie.setPath("/");
                        response.addCookie(usernameCookie);
               //     }
                }
       
                //request.setAttribute("user", user);
                session.setAttribute("user", user);
                response.sendRedirect("Home");
                //request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);                
                return;
            }
            
            else{
                message ="Invalid username or password";
            }
        }
        
        else{
            message ="Both username and password are required.";
        }
        
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
    }    
 }
       

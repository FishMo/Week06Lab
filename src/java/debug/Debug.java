/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debug;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 709317
 */
public class Debug extends TagSupport {
    
    @Override
    public int doStartTag() throws JspException{
        
     
        String request = pageContext.getRequest().getServerName();
        String debug = pageContext.getRequest().getParameter("debug");


            if(debug!= null && !debug.isEmpty()&& (request.startsWith("test") || request.equals("localhost")))
            {
            
               return EVAL_BODY_INCLUDE;
            }       
        return SKIP_BODY;
    }
    
    
}



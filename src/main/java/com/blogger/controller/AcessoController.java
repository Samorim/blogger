
package com.blogger.controller;

import com.blogger.model.usuario.UsuarioBe;
import com.blogger.model.usuario.UsuarioVo;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AcessoController implements Serializable{
   
    
    private UsuarioVo usuarioVo;
    private UsuarioBe usuarioBe;
    
    public AcessoController(){
     if (usuarioVo ==null){
         usuarioVo = new UsuarioVo();
     }
    }
    
    public String login(){
        
        System.out.println("Login");
        
    if (true){
        return "/index";
    } else
        return null;
              
    }
    
       
    public String flowLogin() {
        return "/login";
    }

    public UsuarioVo getUsuarioVo() {
        return usuarioVo;
    }

    public void setUsuarioVo(UsuarioVo usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public UsuarioBe getUsuarioBe() {
        if(usuarioBe ==null){
           usuarioBe = new UsuarioBe();
        }
        
        return usuarioBe;
    }

    
    
    
}

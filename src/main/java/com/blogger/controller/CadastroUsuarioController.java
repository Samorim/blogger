
package com.blogger.controller;

import com.blogger.model.usuario.UsuarioBe;
import com.blogger.model.usuario.UsuarioVo;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CadastroUsuarioController implements Serializable {
    
    private UsuarioVo usuarioVo;
    private UsuarioBe usuarioBe;

    public UsuarioBe getUsuarioBe() {
       if(this.usuarioBe ==null){
           this.usuarioBe = new UsuarioBe();
           }
        
        return usuarioBe;
    }
    
    public void cadastrarUsuario(){
       getUsuarioBe().cadastrarUsuario(usuarioVo);
        
    }
      
    public CadastroUsuarioController() {
        if (this.usuarioVo ==null ){
        this. usuarioVo = new UsuarioVo();
        }
    }

    public UsuarioVo getUsuarioVo() {
        return usuarioVo;
    }
    
     public String flowCadastrarUsuario(){
        return "/usuario/cadastro-usuario";
    }
    
    
    
    public void setUsuarioVo(UsuarioVo usuarioVo) {
        this.usuarioVo = usuarioVo;
    }
    
    
    
}


package com.blogger.model.usuario;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class UsuarioBe implements Serializable{
    public void cadastrarUsuario(UsuarioVo usuarioVo){
        System.out.println("Cadastrado: "+usuarioVo.getNome());
        
        EntityManagerFactory fabricaConexao =  Persistence.createEntityManagerFactory("BLOG_PG_PU");
        EntityManager conexao= fabricaConexao.createEntityManager();
        
        EntityTransaction tx = conexao.getTransaction();
        tx.begin();
        
        conexao.persist(usuarioVo);
        
        tx.commit();
        
        conexao.close();
        fabricaConexao.close();
        
    }
}

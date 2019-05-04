package com.blogger.model.usuario;

import com.blogger.features.persistence.PersistenceProperties;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.collection.internal.PersistentMap;

public class UsuarioBe implements Serializable {

    public void cadastrarUsuario(UsuarioVo usuarioVo) {
        System.out.println("Cadastrado: " + usuarioVo.getNome());

        validarCadastroUsuario(usuarioVo);
        
        EntityManagerFactory fabricaConexao = Persistence.createEntityManagerFactory("BLOG_PG_PU", new PersistenceProperties().getConfigPersistence());
        EntityManager conexao = fabricaConexao.createEntityManager();

        EntityTransaction tx = conexao.getTransaction();
        tx.begin();

        conexao.persist(usuarioVo);

        tx.commit();

        conexao.close();
        fabricaConexao.close();

    }

    private void validarCadastroUsuario(UsuarioVo usuario) {

        if (usuario.getNome().equals("")) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (usuario.getEmail().equals("")) {
            throw new IllegalArgumentException("Email é obrigatório");
        }
        if (usuario.getSenha().equals("")) {
            throw new IllegalArgumentException("Senha é obrigatório");
        }
    }

}
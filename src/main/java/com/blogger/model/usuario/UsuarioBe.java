package com.blogger.model.usuario;

import com.blogger.features.exceptions.DaoException;
import com.blogger.features.security.ControleAcesso;
import com.blogger.model.abstracts.AbstractBe;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

public class UsuarioBe extends AbstractBe {

    private UsuarioDao usuarioDao;

    public void cadastrarUsuario(UsuarioVo usuarioVo) {
        System.out.println("Cadastrado: " + usuarioVo.getNome());

        validarCadastroUsuario(usuarioVo);

        EntityManager conexao = getConexao();

        EntityTransaction tx = conexao.getTransaction();
        tx.begin();

        conexao.persist(usuarioVo);

        tx.commit();

        conexao.close();

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

    public void pesquisarUsuarioPorEmailSenha(UsuarioVo param) throws DaoException {

        System.out.println(param);

        EntityManager em = getConexao();
        try {
            this.usuarioDao = new UsuarioDao(em);
            UsuarioVo usuario = usuarioDao.pesquisarUsuarioPorEmailSenha(param);
            ControleAcesso.login(usuario);

        } catch (NoResultException e) {
            throw new DaoException("Verifique os dados informados", e);
        } catch (DaoException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            close(em);
        }
    }

}

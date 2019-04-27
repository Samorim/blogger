package com.blogger.controller;

import com.blogger.model.usuario.post.PostBe;
import com.blogger.model.usuario.post.PostVo;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class CadastrarPostController implements Serializable {

    private PostBe postBe;
    private PostVo postVo;

    public CadastrarPostController() {
        if (postVo == null) {
            postVo = new PostVo();
        }
    }

    public void cadastrarPost() {
        try {
            getPostBe().cadastrarPost(postVo);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Salvo", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }

    }

    public PostBe getPostBe() {
        if (postBe == null) {
            postBe = new PostBe();
        }

        return postBe;
    }

    public void setPostbe(PostBe postbe) {
        this.postBe = postbe;
    }

    public PostVo getPostvo() {
        return postVo;
    }

    public void setPostvo(PostVo postvo) {
        this.postVo = postvo;
    }

}

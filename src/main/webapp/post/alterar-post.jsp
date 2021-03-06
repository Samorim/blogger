<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:pt="http://xmlns.jcp.org/jsf/passthrough"
      xmlns:p="http://primefaces.org/ui">
    <ui:composition template="/WEB-INF/templates/default-template.xhtml">
        <ui:define name="body" >
            <!-- Main Content -->
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-md-10 mx-auto">
                        #{alterarPostController.consultarPost()}
                        <h:form>
                            <div class="control-group">
                                <h:messages errorClass="alert alert-warning" infoClass="alert alert-success" warnClass="alert alert-warning" style="list-style-type: none;" ></h:messages>
                            </div>
                            <div class="control-group">
                                <div class="form-group floating-label-form-group controls">
                                    <label>Titulo</label>
                                    <h:inputTextarea id="post-titulo" value="#{alterarPostController.postVo.titulo}" rows="2" required="true" requiredMessage="T�tulo � obrigat�rio" class="form-control" pt:placeholder="T�tulo" ></h:inputTextarea>
                                </div>
                            </div>
                            <br/>
                            <div class="control-group">
                                <div class="form-group floating-label-form-group controls">
                                    <label>Titulo</label>
                                    <h:inputTextarea id="post-resumo" value="#{alterarPostController.postVo.resumo}" rows="3" required="true" requiredMessage="Resumo � obrigat�rio" class="form-control" pt:placeholder="Resumo" ></h:inputTextarea>
                                </div>
                            </div>
                            <br/>
                            <div class="control-group">
                                <div class="form-group floating-label-form-group controls">
                                    <p:textEditor id="editor" widgetVar="editorWidget" value="#{alterarPostController.postVo.texto}" height="300"  />
                                </div>
                            </div>
                            <br/>
                            <div id="success"></div>
                            <div class="form-group">
                                <h:commandButton class="btn btn-primary" value="SALVAR" action="${alterarPostController.salvarAlteracao()}" >
                                </h:commandButton>
                            </div>
                        </h:form>
                    </div>
                </div>
            </div>
            <hr/>
        </ui:define>
    </ui:composition>
</html>

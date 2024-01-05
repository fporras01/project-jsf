/**
 * 
 */
package com.devfrancisco.projectjsf.controllers;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

/**
 * @author FranciscoMPH Clase que permite controlar el funcionamiento con la
 *         pantalla de login.xhtml
 */
@ManagedBean
public class LoginController {
	private String usuario;
	private String password;

	/** Metodo que permite ingresar a la pantalla principal del proyecto **/
	public void ingresar() {
		System.out.println("Usuario: " + usuario);
		if (usuario.equals("devfrancisco") && password.equals("123")) {
			try {
				this.redireccionar("principal.xhtml");
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage("formLogin:txtusuario",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "La pagina principal no existe", ""));
				e.printStackTrace();
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("formLogin:txtusuario",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña incorrecto", ""));
		}
	}

	/** Metodo que permite **/
	private void redireccionar(String pagina) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(pagina);
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}

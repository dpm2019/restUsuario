package pe.upc.usuarios.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private Long id_usuario;
    @NotBlank
    private String nombres;
    @NotBlank
    private String apellidos;
    @NotBlank
    private String pais;
    @NotBlank
    private String departamento;
    @NotBlank
    private String telefono;
    @NotBlank
    private String correo;
    @NotBlank
    private String token;

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

package br.com.fiap.segurancaPublica.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name= "TBL_OCORRENCIAS")
public class Ocorrencia {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TBL_OCORRENCIA_SEQ"

    )
    @SequenceGenerator(
            name = "TBL_OCORRENCIA_SEQ",
            sequenceName = "TBL_OCORRENCIA_SEQ",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "tipo_ocorrencia")
    private String tipoOcorrencia;
    @Column(name = "data_ocorrencia")
    private LocalDate dataOcorrencia;
    private String status;
    private String descricao;
    private String email;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(String tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ocorrencia that = (Ocorrencia) o;
        return Objects.equals(id, that.id) && Objects.equals(tipoOcorrencia, that.tipoOcorrencia) && Objects.equals(dataOcorrencia, that.dataOcorrencia) && Objects.equals(status, that.status) && Objects.equals(descricao, that.descricao) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoOcorrencia, dataOcorrencia, status, descricao, email);
    }
}

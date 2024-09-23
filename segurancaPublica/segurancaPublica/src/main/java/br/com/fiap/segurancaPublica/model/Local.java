package br.com.fiap.segurancaPublica.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name= "TBL_LOCAL")
public class Local {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TBL_LOCAL_SEQ"

    )
    @SequenceGenerator(
            name = "TBL_LOCAL_SEQ",
            sequenceName = "TBL_LOCAL_SEQ",
            allocationSize = 1
    )
    @Column(name = "id_local")
    private Long idLocal;
    private String cep;
    private String prioridade;

    public Long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Local local = (Local) o;
        return Objects.equals(idLocal, local.idLocal) && Objects.equals(cep, local.cep) && Objects.equals(prioridade, local.prioridade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocal, cep, prioridade);
    }
}
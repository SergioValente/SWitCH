package aula12_14112017;

import java.util.Date;

public class Tarefa {

	private String descricao;
	private Date dataCriacaoTarefa;
	private Date dataPrevistaConclusao;
	private Date dataComeco;
	private Date dataConclusaoEfetiva;

	public Tarefa(String descricao, Date dataCriacaoTarefa, Date dataPrevistaConclusao, Date dataComeco) {
		super();
		this.descricao = descricao;
		this.dataCriacaoTarefa = dataCriacaoTarefa;
		this.dataPrevistaConclusao = dataPrevistaConclusao;
		this.dataComeco = dataComeco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacaoTarefa == null) ? 0 : dataCriacaoTarefa.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (dataCriacaoTarefa == null) {
			if (other.dataCriacaoTarefa != null)
				return false;
		} else if (!dataCriacaoTarefa.equals(other.dataCriacaoTarefa))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	public Date getDataCriacaoTarefa() {
		return dataCriacaoTarefa;
	}

	public Date getDataComeco() {
		return dataComeco;
	}

	public Date getDataConclusaoEfetiva() {
		return dataConclusaoEfetiva;
	}

	public void setDataConclusaoEfetiva(Date dataConclusaoEfetiva) {
		this.dataConclusaoEfetiva = dataConclusaoEfetiva;
	}

	@Override
	public String toString() {
		return "Tarefa [descricao=" + descricao + ", dataCriacaoTarefa=" + dataCriacaoTarefa
				+ ", dataPrevistaConclusao=" + dataPrevistaConclusao + ", dataComeco=" + dataComeco
				+ ", dataConclusaoEfetiva=" + dataConclusaoEfetiva + "]";
	}

}

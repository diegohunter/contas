package andrade.dev.contas.repository.queries;

public class RelatorioDonativoQueries {

	public static final String QUERY_PESQUISAR =
			"SELECT "
			+ "	rel "
			+ "FROM RelatorioDonativo rel "
			+ "WHERE "
			+ "	(:ano = null OR rel.ano = :ano) and (:mes = null OR rel.mes = :mes)";
			
	
}

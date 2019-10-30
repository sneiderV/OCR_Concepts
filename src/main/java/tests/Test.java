package tests;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser.Operator;
import org.apache.lucene.search.Query;

public class Test {

	String text = "                                                  ASESOFTWARE   \r\n"
			+ "                                                                \r\n"
			+ "                                                                 \r\n"
			+ "                                                                 \r\n"
			+ "                                                                 \r\n"
			+ "                                                                 \r\n"
			+ "                                  HOJA DE VIDA                   \r\n"
			+ "                                                                 \r\n"
			+ " Datos personates                                                \r\n"
			+ "                                                                 \r\n"
			+ "                                                                 \r\n"
			+ "Nombres:                        Johan Steven Capera Pefiuela     \r\n"
			+ "Profesibn:                      Ingenieria en Sistemas           \r\n"
			+ "Fecha de nacimiento:            05/08/1995                       \r\n"
			+ "Cbdula de ciudadania:           1023006157                       \r\n"
			+ "Telbfono:                       3108541343                       \r\n"
			+ "e mail:                         iscaoeraOasesoftware.com         \r\n"
			+ "Cargo actual:                   Analista Sistemas Intermedio     \r\n"
			+ "                                                                 \r\n"
			+ "                                                                 \r\n"
			+ "                                                                 \r\n"
			+ "Perfil Profesional                                               \r\n" + "";

	public static void main(String[] args) {
		
	}

}

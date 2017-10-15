package aula01_03102017;

/**
 * Classe de teste para a classe Contacto
 * @author sergiovalente
 *
 */
public class ContactoTeste {

	public static void main(String[] args) {
			
		Contacto c1 = new Contacto("Maria", "123456789");
		Contacto c2 = new Contacto("Manuel", "987654321");
		
		System.out.println(c1.getNome());
		System.out.println(c2.getNome());
		
		c1.setNome("Maria Antónia");

		System.out.println(c1.getNome());
		System.out.println(c2.getNome());
	}

}

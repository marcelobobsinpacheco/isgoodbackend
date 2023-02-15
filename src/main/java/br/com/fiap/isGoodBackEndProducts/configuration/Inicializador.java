package br.com.fiap.isGoodBackEndProducts.configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.isGoodBackEndProducts.models.Avaliacao;
import br.com.fiap.isGoodBackEndProducts.models.Empresa;
import br.com.fiap.isGoodBackEndProducts.models.Favorito;
import br.com.fiap.isGoodBackEndProducts.models.Produto;
import br.com.fiap.isGoodBackEndProducts.models.Usuario;
import br.com.fiap.isGoodBackEndProducts.repositories.AvaliacaoRepository;
import br.com.fiap.isGoodBackEndProducts.repositories.EmpresaRepository;
import br.com.fiap.isGoodBackEndProducts.repositories.FavoritoRepository;
import br.com.fiap.isGoodBackEndProducts.repositories.ProdutoRepository;
import br.com.fiap.isGoodBackEndProducts.repositories.UsuarioRepository;

@Component
public class Inicializador {

	private static ArrayList<Usuario> firstUsers = new ArrayList<Usuario>();
	private static ArrayList<Empresa> firstEmpresas = new ArrayList<Empresa>();
	private static ArrayList<Produto> firstProdutos = new ArrayList<Produto>();
	private static ArrayList<Avaliacao> firstAvaliacoes = new ArrayList<Avaliacao>();
	private static ArrayList<Favorito> firstFavoritos = new ArrayList<Favorito>();
//	private static EntityManager em = null;

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private FavoritoRepository favoritoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostConstruct
	public void start() {
		try {
			// Verificando se a base de dados existe...
			List<Usuario> usrList = usuarioRepository.findAll();
			if (usrList == null || usrList.isEmpty()) {
				log("Iniciando dados da base...", "WARN");
				iniciaBD();
				usrList = usuarioRepository.findAll();
			}
			log(String.format("Confirmação da base de dados: OK... Usuário de exemplo: %s", usrList.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void iniciaBD() {
		log("Gravando primeiros Usuários...","WARN");
		usuarioRepository.saveAll(getFirstUsers());
		log("Gravando primeiras Empresas...","WARN");
		empresaRepository.saveAll(getFirstEmpresas());
		log("Gravando primeiros Produtos...","WARN");
		produtoRepository.saveAll(getFirstProdutos());
		log("Gravando primeiras Avaliações...","WARN");
		avaliacaoRepository.saveAll(getFirstAvaliacoes());
		log("Gravando primeiros Favoritos...","WARN");
		favoritoRepository.saveAll(getFirstFavoritos());
		log("Processos finalizados...");
	}
	
	private static ArrayList<Usuario> getFirstUsers() {
		ArrayList<Usuario> al = new ArrayList<Usuario>();
		al.add(new Usuario("Willian Andrade", "williandrade@gmail.com", "senha123", "88000-123"));
		al.add(new Usuario("Enzo da Silva", "enzo_persona@gmail.com", "enzo123@", "12908-092"));
		al.add(new Usuario("Daniel Paiva", "danielPaiva@gmail.com", "1234@12", "88209-082"));
		al.add(new Usuario("Fada Madrinha", "contato@fairyland.com.br", "encanto@12", "21223-000"));
		al.add(new Usuario("Juliana Paes", "ju_persona@gmail.com", "ju123@12", "86975-000"));
		firstUsers.addAll(al);
		return al;
	}

	private static ArrayList<Empresa> getFirstEmpresas() {
		ArrayList<Empresa> al = new ArrayList<Empresa>();
		al.add(new Empresa("Rabodigalo DB","contemporâneo,autoral,repleto de bons momentos", firstUsers.get(4), "R. Clodorico Moreira, 23 - Santa Monica,Florianópolis - SC", "88035-012",
				"https://www.facebook.com/rabodigalo/", "", "https://www.instagram.com/rabodigalo/", "",-27.59066677191646,-48.51348197402769,
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnzs1Ay-Zt6Zn7gAW3wSiNO6_gjsf-pBabbg&usqp=CAU",4));
		
		al.add(new Empresa("Mr. Hoppy DB","A REDE QUE MAIS VENDE BURGER E CHOPE ARTESANAL NO BRASIL!",firstUsers.get(2), "Av. Me. Benvenuta, 1037 - Santa Monica, Florianópolis - SC", "88035-000",
				"https://www.facebook.com/mrhoppysantamonica", "", "https://www.instagram.com/mrhoppysantamonica/", "",-27.59047354972215,-48.51134759819293,
				"https://mrhoppy.com.br/wp-content/uploads/2021/03/logo.png",3));
		
		al.add(new Empresa("Afonso Burger Bar - Santa Mônica DB","HAMBURGUERIA Funcionamos de segunda a sábado 07:00 às 23:00 88 996602244 ACEITAMOS CARTÃO DE CREDITO E PIX!!",
				firstUsers.get(3), "Av. Me. Benvenuta, 1074 - Santa Monica, Florianópolis - SC", "88035-000",
				"https://www.facebook.com/afonsoburger/", "", "https://www.instagram.com/afonso_burguer/", "",-27.590681084689262,-48.51080929289238,
				"https://assets.untappd.com/venuelogos/venue_4943833_1ca95ec1_bg_176.png?v=1",5));
		firstEmpresas.addAll(al);
		return al;
	}

	private static ArrayList<Produto> getFirstProdutos() {
		ArrayList<Produto> al = new ArrayList<Produto>();
		al.add(new Produto(firstEmpresas.get(0), "X-Tudão", "Lanche completo, com tudo o que tem no cardápio",4,"https://img.itdg.com.br/tdg/images/recipes/000/161/709/342919/342919_original.jpg?mode=crop&width=710&height=400"));
		al.add(new Produto(firstEmpresas.get(1), "Hamburguer + Fritas",
				"Hamburguer do dia com batata-frita",3,"https://i.pinimg.com/736x/d8/68/dc/d868dcc36646a649dc1898668711ef6b.jpg"));
		al.add(new Produto(firstEmpresas.get(2), "Hambuguer Monstro",
				"Hamburguer big de 350g, no pão brioche, salada e molho especial",2,"https://guiachef.com.br/wp-content/uploads/2019/07/10-ex%C3%B3ticos-hamb%C3%BArgueres-do-mundo-Vegan.jpg"));
		firstProdutos.addAll(al);
		return al;
	}

	private static ArrayList<Avaliacao> getFirstAvaliacoes() {
		ArrayList<Avaliacao> al = new ArrayList<Avaliacao>();
		al.add(new Avaliacao(firstUsers.get(0), firstProdutos.get(0), 5, "Melhor XTudo da vida!!"));
		al.add(new Avaliacao(firstUsers.get(1), firstProdutos.get(0), 3, "Bom, mas já comi melhores"));
		al.add(new Avaliacao(firstUsers.get(1), firstProdutos.get(1), 4, "Parabéns! Estava muito bom"));
		al.add(new Avaliacao(firstUsers.get(1), firstProdutos.get(2), 1,
				"Bolo seco, difícil de engolir. Queria meu dinheiro de volta."));
		al.add(new Avaliacao(firstUsers.get(0), firstProdutos.get(2), 5, "Perfeito!"));
		firstAvaliacoes.addAll(al);
		return al;
	}

	private static ArrayList<Favorito> getFirstFavoritos() {
		ArrayList<Favorito> al = new ArrayList<Favorito>();
		al.add(new Favorito(firstUsers.get(0), firstProdutos.get(0), 1));
		al.add(new Favorito(firstUsers.get(0), firstProdutos.get(2), 2));
		al.add(new Favorito(firstUsers.get(1), firstProdutos.get(1), 1));

		firstFavoritos.addAll(al);
		return al;
	}

	private static void log(String logText) {
		log(logText, "INFO");
	}

	private static void log(String logText, String logType) {
		if (logText == "line")
			logText = "===========================================";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.printf("%s | %s: %s\n", formatter.format(calendar.getTime()), logType, logText);
	}

}

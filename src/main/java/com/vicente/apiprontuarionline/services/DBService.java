package com.vicente.apiprontuarionline.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicente.apiprontuarionline.model.Contato;
import com.vicente.apiprontuarionline.model.ContatoEmergencia;
import com.vicente.apiprontuarionline.model.Endereco;
import com.vicente.apiprontuarionline.model.Paciente;
import com.vicente.apiprontuarionline.repositories.ContatoEmergenciaRepository;
import com.vicente.apiprontuarionline.repositories.ContatoRepository;
import com.vicente.apiprontuarionline.repositories.EnderecoRepository;
import com.vicente.apiprontuarionline.repositories.PacienteRepository;

@Service
public class DBService {

	@Autowired
	PacienteRepository pacienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	ContatoRepository contatoRepository;
	@Autowired
	ContatoEmergenciaRepository contatoEmergenciaRepository;
	// @Autowired
	// DocumentoIdentificacaoRepository documentoIdentificacaoRepository;

	public void instatiateTestDatabase() throws ParseException {

		// PACIENTES //
		// DATA
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// PACIENTE 1
		Paciente paciente1 = new Paciente();
		paciente1.setNome("Antonio");
		paciente1.setSobrenomeCompleto("José de Oliveira Ramos");
		paciente1.setSexo("Masculino");
		paciente1.setDataNascimento(sdf.parse("11/01/1992"));

		// PACIENTE 2
		Paciente paciente2 = new Paciente();
		paciente2.setNome("Maria");
		paciente2.setSobrenomeCompleto("Montenegro dos Santos");
		paciente2.setSexo("Feminino");
		paciente2.setDataNascimento(sdf.parse("05/06/1985"));

		// ENDEREÇOS //
		// PACIENTE 1
		Endereco endereco1 = new Endereco();
		endereco1.setRua("Rua das Cerejeiras");
		endereco1.setNumero("1516");
		endereco1.setBairro("Jardins das Flores");
		endereco1.setComplemento("Prox. ao Bairro Floresta Encatanda");
		endereco1.setCidade("Fortaleza");
		endereco1.setEstado("CE");
		endereco1.setPais("Brasil");
		endereco1.setCodigoPostal("60.761-671");

		// PACIENTE 2
		Endereco endereco2 = new Endereco();
		endereco2.setRua("Rua das Margaridas");
		endereco2.setNumero("2121");
		endereco2.setBairro("Jardins das Plantas");
		endereco2.setComplemento("Prox. ao Bairro Nova Floresta");
		endereco2.setCidade("Maracanaú");
		endereco2.setEstado("CE");
		endereco2.setPais("Brasil");
		endereco2.setCodigoPostal("60.606-975");

		// PACIENTE 3
		Endereco endereco3 = new Endereco();
		endereco3.setRua("Rua das Palmeiras");
		endereco3.setNumero("3297");
		endereco3.setBairro("Floresta Trópical");
		endereco3.setComplemento("Linha do equador");
		endereco3.setCidade("Caucaia");
		endereco3.setEstado("CE");
		endereco3.setPais("Brasil");
		endereco3.setCodigoPostal("60.808-789");

		paciente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco3));
		paciente2.getEnderecos().addAll(Arrays.asList(endereco2));

		// CONTATOS //
		// PACIENTE 1
		Contato contato1 = new Contato();
		contato1.setEmail("antonio@gmail.com");
		contato1.setTelefoneFixo("(85) 3254-0910");
		contato1.setTelefoneCelular("(85) 9 9900-5151");

		// PACIENTE 2
		Contato contato2 = new Contato();
		contato2.setEmail("eduardocarloseduardohenryferreira-98@fazergourmet.com.br");
		contato2.setTelefoneFixo("(85) 3893-1904");
		contato2.setTelefoneCelular("(85) 98899-2082");

		// PACIENTE 1
		Contato contato3 = new Contato();
		contato3.setEmail("mariamontenegro@gmail.com");
		contato3.setTelefoneFixo("(85) 2861-4390");
		contato3.setTelefoneCelular("(85) 98997-5373");

		paciente1.getContatos().addAll(Arrays.asList(contato1, contato3));
		paciente2.getContatos().addAll(Arrays.asList(contato2));

		// CONTATOS DE EMERGÊNCIAS //
		// PACIENTE 1
		ContatoEmergencia contatoEmergencia1 = new ContatoEmergencia();
		contatoEmergencia1.setNome("Carlos");
		contatoEmergencia1.setSobrenomeCompleto("Manuel Bruno Souza");
		contatoEmergencia1.setRg("46.360.067-8");
		contatoEmergencia1.setCpf("362.127.193-73");
		contatoEmergencia1.setEmail("carlosmanuelbrunosouza_@dosnu.com.br");
		contatoEmergencia1.setTelefoneFixo("(85) 2861-4390");
		contatoEmergencia1.setTelefoneCelular("(85) 98997-5373");

		// PACIENTE 2
		ContatoEmergencia contatoEmergencia2 = new ContatoEmergencia();
		contatoEmergencia2.setNome("Eduardo");
		contatoEmergencia2.setSobrenomeCompleto("Carlos Eduardo Henry Ferreira");
		contatoEmergencia2.setRg("31.951.115-7");
		contatoEmergencia2.setCpf("579.232.073-05");
		contatoEmergencia2.setEmail("eduardocarloseduardohenryferreira-98@fazergourmet.com.br");
		contatoEmergencia2.setTelefoneFixo("(85) 3893-1904");
		contatoEmergencia2.setTelefoneCelular("(85) 98899-2082");

		// PACIENTE 3
		ContatoEmergencia contatoEmergencia3 = new ContatoEmergencia();
		contatoEmergencia3.setNome("Simone ");
		contatoEmergencia3.setSobrenomeCompleto("Jaqueline Lopes");
		contatoEmergencia3.setRg("23.248.831-9");
		contatoEmergencia3.setCpf("665.684.263-18");
		contatoEmergencia3.setEmail("simonejaquelinelopes_@vetech.vet.br");
		contatoEmergencia3.setTelefoneFixo("(85) 3604-4488");
		contatoEmergencia3.setTelefoneCelular("(85) 99730-2303");

		paciente1.getContatosEmergencias().addAll(Arrays.asList(contatoEmergencia1));
		paciente2.getContatosEmergencias().addAll(Arrays.asList(contatoEmergencia2, contatoEmergencia3));

		// DOCUMENTOS DE IDENTIFICAÇÃO
		// PACIENTE 1
//		DocumentoIdentificacao documentoIdentificacao1 = new DocumentoIdentificacao();
//		documentoIdentificacao1.setRg("16.795.506-8");
//		documentoIdentificacao1.setCpf("818.774.980-68");
//
//		// PACIENTE 2
//		DocumentoIdentificacao documentoIdentificacao2 = new DocumentoIdentificacao();
//		documentoIdentificacao2.setRg("33.328.380-6");
//		documentoIdentificacao2.setCpf("269.670.880-09");
//
//		paciente1.setDocumentoIdentificacao(documentoIdentificacao1);
//		paciente2.setDocumentoIdentificacao(documentoIdentificacao2);
//
//		documentoIdentificacao1.setPaciente(paciente1);
//		documentoIdentificacao2.setPaciente(paciente2);

//		// ESTADO FISÍCO DO PACIENTE
//		// PACIENTE 1
//		PacienteEstadoFisico pacienteEstadoFisico1 = new PacienteEstadoFisico();
//		pacienteEstadoFisico1.setPeso(1.65);
//		pacienteEstadoFisico1.setAltura(79.0);
//		pacienteEstadoFisico1.setTipoSanquineo("A+");
//		pacienteEstadoFisico1.setCircuferenciaAbdominal(0.60);
//		pacienteEstadoFisico1.setImc(29.02);
//
//		// PACIENTE 2
//		PacienteEstadoFisico pacienteEstadoFisico2 = new PacienteEstadoFisico();
//		pacienteEstadoFisico2.setPeso(1.69);
//		pacienteEstadoFisico2.setAltura(90.0);
//		pacienteEstadoFisico2.setTipoSanquineo("B-");
//		pacienteEstadoFisico2.setCircuferenciaAbdominal(0.85);
//		pacienteEstadoFisico2.setImc(31.51);
//
//		paciente1.setPacienteEstadoFisico(pacienteEstadoFisico1);
//		paciente2.setPacienteEstadoFisico(pacienteEstadoFisico2);
//		pacienteEstadoFisico1.setPaciente(paciente1);
//		pacienteEstadoFisico2.setPaciente(paciente2);
//
//		// EXAME DE ANAMNESIS
//		// PACIENTE 1
//		PacienteExameAnamnese pacienteExameAnamnese1 = new PacienteExameAnamnese();
//		pacienteExameAnamnese1.setAlergia(true);
//		pacienteExameAnamnese1.setAlcool(false);
//		pacienteExameAnamnese1.setDieta(true);
//		pacienteExameAnamnese1.setFuma(false);
//		pacienteExameAnamnese1.setAtividadeFisica(true);
//
//		// PACIENTE 2
//		PacienteExameAnamnese pacienteExameAnamnese2 = new PacienteExameAnamnese();
//		pacienteExameAnamnese2.setAlergia(false);
//		pacienteExameAnamnese2.setAlcool(true);
//		pacienteExameAnamnese2.setDieta(false);
//		pacienteExameAnamnese2.setFuma(true);
//		pacienteExameAnamnese2.setAtividadeFisica(false);
//
//		paciente1.setPacienteExameAnamnese(pacienteExameAnamnese1);
//		paciente2.setPacienteExameAnamnese(pacienteExameAnamnese2);
//		pacienteExameAnamnese1.setPaciente(paciente1);
//		pacienteExameAnamnese2.setPaciente(paciente2);
////

		pacienteRepository.saveAll(Arrays.asList(paciente1, paciente2));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));
		contatoRepository.saveAll(Arrays.asList(contato1, contato2, contato3));
		contatoEmergenciaRepository.saveAll(Arrays.asList(contatoEmergencia1, contatoEmergencia2, contatoEmergencia3));
//		documentoIdentificacaoRepository.saveAll(Arrays.asList(documentoIdentificacao1, documentoIdentificacao2));
//		pacienteEstadoFisicoRepository.saveAll(Arrays.asList(pacienteEstadoFisico1, pacienteEstadoFisico2));
//		pacienteExameAnamneseRepository.saveAll(Arrays.asList(pacienteExameAnamnese1, pacienteExameAnamnese2));

	}
}

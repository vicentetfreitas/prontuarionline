package com.vicente.apiprontuarionline;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vicente.apiprontuarionline.model.Address;
import com.vicente.apiprontuarionline.model.Contact;
import com.vicente.apiprontuarionline.model.EmergencyContact;
import com.vicente.apiprontuarionline.model.IdentificationDocument;
import com.vicente.apiprontuarionline.model.Patient;
import com.vicente.apiprontuarionline.repositories.AddressRepository;
import com.vicente.apiprontuarionline.repositories.ContactRepository;
import com.vicente.apiprontuarionline.repositories.EmergencyContactRepository;
import com.vicente.apiprontuarionline.repositories.IdentificationDocumentRepository;
import com.vicente.apiprontuarionline.repositories.PatientRepository;

@SpringBootApplication
public class ApiProntuarionlineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiProntuarionlineApplication.class, args);
	}

	@Autowired
	PatientRepository patientRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	IdentificationDocumentRepository identificationDocumentRepository;
	@Autowired
	EmergencyContactRepository emergencyContactRepository;

	@Override
	public void run(String... args) throws Exception {

		// PACIENTES
		// DATA
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// PACIENTE 1
		Patient pct1 = new Patient();
		pct1.setFirstName("Antonio");
		pct1.setFullSurname("José de Oliveira Ramos");
		pct1.setGenre("Masculino");
		pct1.setDateOfBirth(sdf.parse("11/01/1992"));

		// PACIENTE 2
		Patient pct2 = new Patient();
		pct2.setFirstName("Maria");
		pct2.setFullSurname("Montenegro dos Santos");
		pct2.setGenre("Feminino");
		pct2.setDateOfBirth(sdf.parse("05/06/1985"));

		// ENDEREÇOS
		// ENDEREÇO 1
		Address add1 = new Address();
		add1.setStreet("Rua das Cerejeiras");
		add1.setNumber("1516");
		add1.setComplement("Jardins das Flores");
		add1.setNeighborhood("Jardins");
		add1.setComplement("Prox. ao Bairro Floresta Encatanda");
		add1.setCity("Fortaleza");
		add1.setState("CE");
		add1.setCountry("Brasil");
		add1.setPostalCode("60.761-671");

		// ENDEREÇO 2
		Address add2 = new Address();
		add2.setStreet("Rua das Margaridas");
		add2.setNumber("2121");
		add2.setComplement("Jardins das Plantas");
		add2.setNeighborhood("Floresta");
		add2.setComplement("Prox. ao Bairro Nova Floresta");
		add2.setCity("Maracanaú");
		add2.setState("CE");
		add2.setCountry("Brasil");
		add2.setPostalCode("60.606-975");

		// ENDEREÇO 3
		Address add3 = new Address();
		add3.setStreet("Rua das Palmeiras");
		add3.setNumber("3297");
		add3.setComplement("Floresta Trópical");
		add3.setNeighborhood("Floresta de Greenwich");
		add3.setComplement("Linha do equador");
		add3.setCity("Caucaia");
		add3.setState("CE");
		add3.setCountry("Brasil");
		add3.setPostalCode("60.808-789");

		// PACIENTE_ENDEREÇO @ManyToMany
		pct1.getAdresses().addAll(Arrays.asList(add1, add3));
		pct2.getAdresses().addAll(Arrays.asList(add2));

		add1.getPatients().addAll(Arrays.asList(pct1));
		add2.getPatients().addAll(Arrays.asList(pct2));
		add3.getPatients().addAll(Arrays.asList(pct1));

		patientRepository.saveAll(Arrays.asList(pct1, pct2));
		addressRepository.saveAll(Arrays.asList(add1, add2, add3));

		// CONTATO 1
		Contact cnt1 = new Contact();

		cnt1.setPhones(Arrays.asList("(85) 3254-0910", "(85) 3255-0911"));
		cnt1.setEmails(Arrays.asList("antonio@gmail.com", "antoniojose@yahoo.com"));
		cnt1.setContactNumbers(Arrays.asList("(85) 9 9900-5151", "(85) 9 9911-4748"));

		// CONTATO 2
		Contact cnt2 = new Contact();
		cnt2.setPhones(Arrays.asList("(85) 3274-2516", "(85) 3344-0907"));
		cnt2.setEmails(Arrays.asList("maria@gmail.com", "mariamontenegro@outlook.com"));
		cnt2.setContactNumbers(Arrays.asList("(85) 9 9900-5151", "(85) 9 9911-4748"));

		// PACIENTE_CONTATO @ManyToMany
		pct1.getContacts().addAll(Arrays.asList(cnt1));
		pct2.getContacts().addAll(Arrays.asList(cnt2));

		cnt1.getPatients().addAll(Arrays.asList(pct1));
		cnt2.getPatients().addAll(Arrays.asList(pct2));

		contactRepository.saveAll(Arrays.asList(cnt1, cnt2));
		patientRepository.saveAll(Arrays.asList(pct1, pct2));

		// CONTATOS DE EMERGÊNCIAS
		// CONTATO DE EMERGÊNCIA 1
		EmergencyContact emct1 = new EmergencyContact();
		emct1.setFirstName("Carlos");
		emct1.setFullSurname("Manuel Bruno Souza");
		emct1.setRg("46.360.067-8");
		emct1.setCpf("362.127.193-73");
		emct1.setEmail("carlosmanuelbrunosouza_@dosnu.com.br");
		emct1.setPhone("(85) 2861-4390");
		emct1.setContactNumber("(85) 98997-5373");

		// CONTATO DE EMERGÊNCIA 2
		EmergencyContact emct2 = new EmergencyContact();
		emct2.setFirstName("Eduardo");
		emct2.setFullSurname("Carlos Eduardo Henry Ferreira");
		emct2.setRg("31.951.115-7");
		emct2.setCpf("579.232.073-05");
		emct2.setEmail("eduardocarloseduardohenryferreira-98@fazergourmet.com.br");
		emct2.setPhone("(85) 3893-1904");
		emct2.setContactNumber("(85) 98899-2082(85) 98899-2082");

		// PACIENTE_CONTATO_EMERGENCIA @ManyToMany
		pct1.getEmergencyContacts().addAll(Arrays.asList(emct1));
		pct2.getEmergencyContacts().addAll(Arrays.asList(emct2));
		emct1.getPatients().addAll(Arrays.asList(pct1));
		emct2.getPatients().addAll(Arrays.asList(pct2));

		emergencyContactRepository.saveAll(Arrays.asList(emct1, emct2));
		patientRepository.saveAll(Arrays.asList(pct1, pct2));

		// DOCUMENTOS DE IDENTIFICAÇÃO
		// DOCUMENTO DE IDENTIFCAÇÃO 1
		IdentificationDocument iddc1 = new IdentificationDocument();
		iddc1.setRg("16.795.506-8");
		iddc1.setCpf("818.774.980-68");


		// DOCUMENTO DE IDENTIFICAÇÃO 2
		IdentificationDocument iddc2 = new IdentificationDocument();
		iddc2.setRg("33.328.380-6");
		iddc2.setCpf("269.670.880-09");
		
		pct1.setIdentificationDocument(iddc1);
		pct2.setIdentificationDocument(iddc2);
		
		iddc1.setPatient(pct1);
		iddc2.setPatient(pct2);
		// PACIENTE_DOCUMENTO_DE_IDENTIFICAÇÃO @OneToOne
		patientRepository.saveAll(Arrays.asList(pct1, pct2));
		identificationDocumentRepository.saveAll(Arrays.asList(iddc1, iddc2));

	}

}

package com.vicente.apiprontuarionline;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vicente.apiprontuarionline.model.Address;
import com.vicente.apiprontuarionline.model.Contact;
import com.vicente.apiprontuarionline.model.IdentificationDocument;
import com.vicente.apiprontuarionline.model.Patient;
import com.vicente.apiprontuarionline.repositories.AddressRepository;
import com.vicente.apiprontuarionline.repositories.ContactRepository;
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
		cnt1.getPhones().addAll(Arrays.asList("(85) 3254-0910", "(85) 3255-0911"));
		cnt1.getEmails().addAll(Arrays.asList("antonio@gmail.com", "antoniojose@yahoo.com"));
		cnt1.getContactNumbers().addAll(Arrays.asList("(85) 9 9900-5151", "(85) 9 9911-4748"));

		// CONTATO 2
		Contact cnt2 = new Contact();
		cnt2.getPhones().addAll(Arrays.asList("(85) 3274-2516", "(85) 3344-0907"));
		cnt2.getEmails().addAll(Arrays.asList("maria@gmail.com", "mariamontenegro@outlook.com"));
		cnt2.getContactNumbers().addAll(Arrays.asList("(85) 9 9900-5151", "(85) 9 9911-4748"));

		pct1.getContacts().addAll(Arrays.asList(cnt1));
		pct2.getContacts().addAll(Arrays.asList(cnt2));

		contactRepository.saveAll(Arrays.asList(cnt1, cnt2));
		patientRepository.saveAll(Arrays.asList(pct1, pct2));

		// INFORMAÇÕES DE CONTATO
		// INFORMAÇÃO 1

		IdentificationDocument iddc1 = new IdentificationDocument();
		iddc1.setRg("16.795.506-8");
		iddc1.setCpf("818.774.980-68");

		// INFORMAÇÃO 2
		IdentificationDocument iddc2 = new IdentificationDocument();
		iddc2.setRg("33.328.380-6");
		iddc2.setCpf("269.670.880-09");

		pct1.setIdentificationDocument(iddc1);
		pct2.setIdentificationDocument(iddc2);

		iddc1.setPatient(pct1);
		iddc2.setPatient(pct2);

		patientRepository.saveAll(Arrays.asList(pct1, pct2));
		
		

	}

}

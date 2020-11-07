package com.vicente.apiprontuarionline;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vicente.apiprontuarionline.model.Address;
import com.vicente.apiprontuarionline.model.Contact;
import com.vicente.apiprontuarionline.model.Patient;
import com.vicente.apiprontuarionline.repositories.AddressRepository;
import com.vicente.apiprontuarionline.repositories.ContactRepository;
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
		Address end1 = new Address();
		end1.setStreet("Rua das Cerejeiras");
		end1.setNumber("1516");
		end1.setComplement("Jardins das Flores");
		end1.setNeighborhood("Jardins");
		end1.setComplement("Prox. ao Bairro Floresta Encatanda");
		end1.setCity("Fortaleza");
		end1.setState("CE");
		end1.setCountry("Brasil");
		end1.setPostalCode("60.761-671");

		// ENDEREÇO 2
		Address end2 = new Address();
		end2.setStreet("Rua das Margaridas");
		end2.setNumber("2121");
		end2.setComplement("Jardins das Plantas");
		end2.setNeighborhood("Floresta");
		end2.setComplement("Prox. ao Bairro Nova Floresta");
		end2.setCity("Maracanaú");
		end2.setState("CE");
		end2.setCountry("Brasil");
		end2.setPostalCode("60.606-975");

		// ENDEREÇO 3
		Address end3 = new Address();
		end3.setStreet("Rua das Palmeiras");
		end3.setNumber("3297");
		end3.setComplement("Floresta Trópical");
		end3.setNeighborhood("Floresta de Greenwich");
		end3.setComplement("Linha do equador");
		end3.setCity("Caucaia");
		end3.setState("CE");
		end3.setCountry("Brasil");
		end3.setPostalCode("60.808-789");

		// PACIENTE_ENDEREÇO @ManyToMany
		pct1.getAdresses().addAll(Arrays.asList(end1, end3));
		pct2.getAdresses().addAll(Arrays.asList(end2));

		end1.getPatients().addAll(Arrays.asList(pct1));
		end2.getPatients().addAll(Arrays.asList(pct2));
		end3.getPatients().addAll(Arrays.asList(pct1));

		patientRepository.saveAll(Arrays.asList(pct1, pct2));
		addressRepository.saveAll(Arrays.asList(end1, end2, end3));

		// CONTATO
		Contact cnt1 = new Contact();
		cnt1.getPhones().addAll(Arrays.asList("(85) 3254-0910", "(85) 3255-0911"));
		cnt1.getEmails().addAll(Arrays.asList("antonio@gmail.com", "antoniojose@yahoo.com"));
		cnt1.getContactNumbers().addAll(Arrays.asList("(85) 9 9900-5151", "(85) 9 9911-4748"));

		Contact cnt2 = new Contact();
		cnt2.getPhones().addAll(Arrays.asList("(85) 3274-2516", "(85) 3344-0907"));
		cnt2.getEmails().addAll(Arrays.asList("maria@gmail.com", "mariamontenegro@outlook.com"));
		cnt2.getContactNumbers().addAll(Arrays.asList("(85) 9 9900-5151", "(85) 9 9911-4748"));
		
		patientRepository.saveAll(Arrays.asList(pct1,pct2));
		contactRepository.saveAll(Arrays.asList(cnt1,cnt2));
	}

}

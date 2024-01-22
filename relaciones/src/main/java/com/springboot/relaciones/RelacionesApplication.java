package com.springboot.relaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.relaciones.entities.*;
import com.springboot.relaciones.repositories.*;
import org.springframework.boot.*;
import java.util.*;

@SpringBootApplication
public class RelacionesApplication implements CommandLineRunner {

	@Autowired
	private IClientRepository clientRepository;
	@Autowired
	private IInvoiceRepository invoiceRepository;

	@Autowired
	private IClientsDetailsRepository clientsDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(RelacionesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Relaciones con clases
		// manyToOne();
		// manyToOneFindByIdClient(23L);
		// oneToMany();
		// oneToManyDelete();
		// oneToManyFindOne();
		// OneToManyBidirectional();
		// OneToManyInvoceBidirectionalFindById();
		// removeOneToManyInvoceBidirectionalFindById();
		// oneToOne();
		// oneToOneFindById();
		oneToOneBidirectional();
	}

	@Transactional
	public void oneToOneBidirectional() {
		Clients client = Clients.builder().name("Developer").lastname("Java").build();
		ClientDetails clientDetails = ClientDetails.builder().premium(true).points(4).build();
		client.setClientDetails(clientDetails);
		clientDetails.setClients(client);
		this.clientRepository.save(client);

	}

	@Transactional
	public void oneToOneFindById() {
		Optional<Clients> client = this.clientRepository.findById(35L);
		client.ifPresent(cli -> {
			System.out.println();
			System.out.println(cli);
			System.out.println();
		});
	}

	@Transactional
	public void oneToOne() {
		ClientDetails clientDetails = ClientDetails.builder().premium(true).points(4).build();
		this.clientsDetailsRepository.save(clientDetails);

		Clients client = Clients.builder().name("Macarena").lastname("Moraga de Haro").build();
		client.setClientDetails(clientDetails);
		this.clientRepository.save(client);

		System.out.println(client);
	}

	@Transactional
	public void removeOneToManyInvoceBidirectionalFindById() {
		// BUsco el cliente
		Optional<Clients> client = this.clientRepository.findOne(34L);

		client.ifPresent(cli -> {
			cli.addInvoice(Invoice.builder().description("Desarrollador Web").total(100L).build())
					.addInvoice(Invoice.builder().description("Java Developer").total(1000L).build());
			// this.clientRepository.save(cli);
		});

		// buscar el cliente de nuevo
		Optional<Clients> clientDB = this.clientRepository.findOne(34L);
		clientDB.ifPresent(cli -> {
			Optional<Invoice> invoiceOptional = this.invoiceRepository.findById(34L);
			invoiceOptional.ifPresent(invoice -> {
				cli.getInvoices().remove(invoice);
				this.clientRepository.save(cli);
				System.out.println(cli);
			});
		});

	}

	@Transactional
	public void OneToManyInvoceBidirectionalFindById() {
		// BUsco el cliente
		Optional<Clients> client = this.clientRepository.findOne(33L);
		System.out.println();
		client.ifPresent(System.out::println);
		System.out.println();
	}

	@Transactional
	public void OneToManyBidirectional() {
		// Creo un cliente
		Clients clients = Clients.builder().name("Macarena").lastname("Moraga").build();
		// Asigno las dos facturas al cliente
		clients.addInvoice(Invoice.builder().description("Hola").total(2L).build())
				.addInvoice(Invoice.builder().description("Hola").total(2L).build());
		this.clientRepository.save(clients);
		// BUsco el cliente
		Optional<Clients> client = this.clientRepository.findById(33L);
		System.out.println();
		client.ifPresent(System.out::println);
		System.out.println();
	}

	@Transactional
	public void oneToManyFindOne() {
		// Busca el cliente
		Optional<Clients> client = this.clientRepository.findOneWithAddresses(31L);
		// Encuentra el cliente
		client.ifPresent(System.out::println);
	}

	@Transactional
	public void oneToManyDelete() {
		// Busca el cliente
		Optional<Clients> client = this.clientRepository.findById(30L);
		// Encuentre el cliente
		client.ifPresent(cli -> {
			cli.getAddresses().remove(1);
			this.clientRepository.save(cli);
			System.out.println(cli);
		});

	}

	@Transactional
	public void oneToMany() {
		// Crear un cliente
		Clients client = Clients.builder().name("Marina").lastname("Guillén").build();

		// Crear una lista de direcciones
		Set<Address> addresses = new HashSet<>();
		addresses.add(Address.builder().street("calle").number(4).build());
		addresses.add(Address.builder().street("avenida").number(6).build());
		client.setAddresses(addresses);

		this.clientRepository.save(client);
		System.out.println(client);
	}

	@Transactional
	public void manyToOne() {

		// crear cliente
		Clients client = Clients.builder().name("Lizandro").lastname("Narváez").build();
		if (client != null)
			this.clientRepository.save(client);
		// Crear factura
		Invoice invoice = Invoice
				.builder()
				.description("Compra de útiles de oficina")
				.total(1200L)
				.build();

		invoice.setClient(client);
		Invoice invoiceDb = this.invoiceRepository.save(invoice);
		System.out.println(invoiceDb);

	}

	@Transactional
	public void manyToOneFindByIdClient(Long id) {

		// buscar cliente
		Optional<Clients> clientFind = this.clientRepository.findById(id);
		if (clientFind.isPresent()) {
			Clients client = clientFind.orElseThrow();
			// Crear factura
			Invoice invoice = Invoice
					.builder()
					.description("Compra de útiles de oficina")
					.total(1200L)
					.build();

			invoice.setClient(client);

			Invoice invoiceDb = this.invoiceRepository.save(invoice);
			System.out.println(invoiceDb);
		}

	}
}

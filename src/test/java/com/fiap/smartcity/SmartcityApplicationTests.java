//package com.fiap.smartcity;
//
//import com.fiap.smartcity.model.Exame;
//import com.fiap.smartcity.model.Medico;
//import com.fiap.smartcity.model.Paciente;
//import com.fiap.smartcity.repository.ExameRepository;
//import com.fiap.smartcity.repository.MedicoRepository;
//import com.fiap.smartcity.repository.PacienteRepository;
//import com.fiap.smartcity.service.ExameService;
//import com.fiap.smartcity.service.MedicoService;
//import com.fiap.smartcity.service.PacienteService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.*;
//
//class SmartcityApplicationTests {
//
//	@Mock
//	private PacienteRepository pacienteRepository;
//
//	@Mock
//	private MedicoRepository medicoRepository;
//
//	@Mock
//	private ExameRepository exameRepository;
//
//	@InjectMocks
//	private PacienteService pacienteService;
//
//	@InjectMocks
//	private MedicoService medicoService;
//
//	@InjectMocks
//	private ExameService exameService;
//
//	@BeforeEach
//	public void setUp() {
//		MockitoAnnotations.openMocks(this);
//	}
//
//	// PacienteService Tests
//	@Test
//	public void testAdicionarPaciente() {
//		Paciente paciente = new Paciente("João", "123456789");
//		when(pacienteRepository.save(any(Paciente.class))).thenReturn(paciente);
//
//		Paciente resultado = pacienteService.adicionarPaciente(paciente);
//
//		assertEquals("João", resultado.getNome());
//	}
//
//	@Test
//	public void testListarPacientes() {
//		when(pacienteRepository.findAll()).thenReturn(Arrays.asList(new Paciente("João", "123456789"), new Paciente("Maria", "987654321")));
//
//		List<Paciente> resultado = pacienteService.listarPacientes();
//
//		assertEquals(2, resultado.size());
//	}
//
//	@Test
//	public void testAtualizarPaciente() {
//		Paciente paciente = new Paciente("João", "123456789");
//		when(pacienteRepository.save(any(Paciente.class))).thenReturn(paciente);
//		when(pacienteRepository.findById(String.valueOf(anyLong()))).thenReturn(Optional.of(paciente));
//
//		paciente.setNome("João Silva");
//		pacienteService.adicionarPaciente(paciente); // Atualiza o paciente
//
//		Optional<Paciente> resultado = pacienteRepository.findById(paciente.getId());
//		assertTrue(resultado.isPresent());
//		assertEquals("João Silva", resultado.get().getNome());
//	}
//
//	@Test
//	public void testRemoverPaciente() {
//		Paciente paciente = new Paciente("João", "123456789");
//		when(pacienteRepository.save(any(Paciente.class))).thenReturn(paciente);
//		when(pacienteRepository.findById(String.valueOf(anyLong()))).thenReturn(Optional.of(paciente));
//		doNothing().when(pacienteRepository).deleteById(String.valueOf(anyLong()));
//
//		pacienteService.removerPaciente(paciente.getId());
//
//		verify(pacienteRepository, times(1)).deleteById(paciente.getId());
//	}
//
//	// MedicoService Tests
//	@Test
//	public void testAdicionarMedico() {
//		Medico medico = new Medico("Dr. Ana", "CRM123");
//		when(medicoRepository.save(any(Medico.class))).thenReturn(medico);
//
//		Medico resultado = medicoService.adicionarMedico(medico);
//
//		assertEquals("Dr. Ana", resultado.getNome());
//	}
//
//	@Test
//	public void testListarMedicos() {
//		when(medicoRepository.findAll()).thenReturn(Arrays.asList(new Medico("Dr. Ana", "CRM123"), new Medico("Dr. Pedro", "CRM456")));
//
//		List<Medico> resultado = medicoService.listarMedicos();
//
//		assertEquals(2, resultado.size());
//	}
//
//	@Test
//	public void testAtualizarMedico() {
//		Medico medico = new Medico("Dr. Ana", "CRM123");
//		when(medicoRepository.save(any(Medico.class))).thenReturn(medico);
//		when(medicoRepository.findById(String.valueOf(anyLong()))).thenReturn(Optional.of(medico));
//
//		medico.setNome("Dra. Ana Silva");
//		medicoService.adicionarMedico(medico); // Atualiza o médico
//
//		Optional<Medico> resultado = medicoRepository.findById(medico.getId());
//		assertTrue(resultado.isPresent());
//		assertEquals("Dra. Ana Silva", resultado.get().getNome());
//	}
//}
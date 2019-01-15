package guru.springframework.services;

import guru.springframework.api.v1.mapper.VendorMapper;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.controllers.v1.VendorController;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class VendorServiceImplTest {

    @Mock
    VendorRepository vendorRepository;

    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    VendorService vendorService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        vendorService = new VendorServiceImpl(vendorMapper, vendorRepository);
    }

    @Test
    public void getAllVendors() throws Exception {
        //given
        Vendor vendor1 = new Vendor();
        vendor1.setId(1l);
        vendor1.setName("Weston");

        Vendor vendor2 = new Vendor();
        vendor2.setId(2l);
        vendor2.setName("Axe");

        when(vendorRepository.findAll()).thenReturn(Arrays.asList(vendor1, vendor2));

        //when
        List<VendorDTO> vendorDTOS = vendorService.getAllVendors();

        //then
        assertEquals(2, vendorDTOS.size());

    }

    @Test
    public void getVendorById() throws Exception {
        //given
        Vendor vendor1 = new Vendor();
        vendor1.setId(1l);
        vendor1.setName("Weston");

        when(vendorRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(vendor1));

        //when
        VendorDTO vendorDTO = vendorService.getVendorById(1L);

        assertEquals("Weston", vendorDTO.getName());
    }

    @Test
    public void createNewVendor() throws Exception {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName("Jim");

        Vendor savedVendor = new Vendor();
        savedVendor.setName(vendorDTO.getName());
        savedVendor.setId(1l);

        when(vendorRepository.save(any(Vendor.class))).thenReturn(savedVendor);

        //when
        VendorDTO savedDto = vendorService.createNewVendor(vendorDTO);

        //then
        assertEquals(vendorDTO.getName(), savedDto.getName());
        assertEquals(VendorController.BASE_URL + "/1", savedDto.getVendorUrl());
    }

    @Test
    public void saveVendorByDTO() throws Exception {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName("Jim");

        Vendor savedVendor = new Vendor();
        savedVendor.setName(vendorDTO.getName());
        savedVendor.setId(1l);

        when(vendorRepository.save(any(Vendor.class))).thenReturn(savedVendor);

        //when
        VendorDTO savedDto = vendorService.saveVendorByDTO(1L, vendorDTO);

        //then
        assertEquals(vendorDTO.getName(), savedDto.getName());
        assertEquals(VendorController.BASE_URL + "/1", savedDto.getVendorUrl());
    }

    @Test
    public void deleteVendorById() throws Exception {

        Long id = 1L;
        vendorService.deleteVendorById(id);
        verify(vendorRepository, times(1)).deleteById(anyLong());
    }
}

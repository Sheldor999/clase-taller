package ubilapaz.edu.bo.clasetaller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubilapaz.edu.bo.clasetaller.domain.Producto;
import ubilapaz.edu.bo.clasetaller.dto.DescuentoDto;
import ubilapaz.edu.bo.clasetaller.dto.ProductoDto;
import ubilapaz.edu.bo.clasetaller.persistence.ProductoRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/list")
    public ResponseEntity<List<DescuentoDto>> list(){
        List<Producto> productoList = productoRepository.findAll();
        List<DescuentoDto> descuentoDtoList = new ArrayList<>();
        for(Producto product: productoList){
            DescuentoDto d1 = new DescuentoDto();
            d1.setNombre(product.getNombre());
            d1.setCod(product.getCodigo());
            d1.setPrecio(product.getPrecio());
            Double des = product.getPrecio()*0.10;
            d1.setDescuento(des);
            descuentoDtoList.add(d1);
        }
        return new ResponseEntity<List<DescuentoDto>>(descuentoDtoList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<String> create(@RequestBody ProductoDto productoDto){
        Producto producto = new Producto();
        producto.setNombre(productoDto.nombre);
        producto.setCodigo(productoDto.cod.toUpperCase());
        producto.setPrecio(productoDto.precio);
        producto.setFechaRegistro(LocalDateTime.now());

        List<Producto> productoList = productoRepository.findAll();
        boolean sw = false;
        for(Producto product: productoList){
            if(producto.getCodigo().equals(product.getCodigo())){
                sw = true;
                return new ResponseEntity<String>("El codigo esta repetido", HttpStatus.OK);
            };
        }

        productoRepository.save(producto);
        return new ResponseEntity<String>("Registro Exitoso", HttpStatus.OK);
    }
}

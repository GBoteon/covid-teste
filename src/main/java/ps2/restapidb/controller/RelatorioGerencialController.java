package ps2.restapidb.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import ps2.restapidb.repository.EstadoSaudeRepo;
import ps2.restapidb.repository.SintomaRepo;
import ps2.restapidb.repository.MembroRepo;

@RestController
public class RelatorioGerencialController {
    @Autowired
    protected EstadoSaudeRepo estadoSaudeRepo;
    
    @Autowired
    protected MembroRepo membroRepo;
    
    @Autowired
    protected SintomaRepo sintomaRepo;

    @GetMapping("/api/relatorios/registros/qtd")
    public List<Object> getQtdRegistros(
        @RequestParam("start") Optional<String> start,
        @RequestParam("end") Optional<String> end
    ) throws ParseException {      
        LocalDateTime now = LocalDateTime.now(); 
        String dateNowFormat = now.getYear() + "-" + now.getMonthValue()+ "-" + now.getDayOfMonth();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateStart = formatter.parse("2021-01-01");
        Date dateEnd = formatter.parse(dateNowFormat);
        
        if(start.isPresent() && !end.isPresent()){
            dateStart = formatter.parse(start.get());
        } else if(start.isPresent() && end.isPresent()) {
            dateStart = formatter.parse(start.get());
            dateEnd = formatter.parse(end.get());
        }      
      
        Optional<List<Object>> s = this.estadoSaudeRepo.getQtdRegistrosDiario(dateStart, dateEnd);
        return s.get();
    }
    
    @GetMapping("/api/relatorios/registros/doentes/qtd")
    public List<Object> getQtdRegistrosNaoMuitoBem(
        @RequestParam("start") Optional<String> start,
        @RequestParam("end") Optional<String> end
    ) throws ParseException {      
        LocalDateTime now = LocalDateTime.now(); 
        String dateNowFormat = now.getYear() + "-" + now.getMonthValue()+ "-" + now.getDayOfMonth();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateStart = formatter.parse("2021-01-01");
        Date dateEnd = formatter.parse(dateNowFormat);
        
        if(start.isPresent() && !end.isPresent()){
            dateStart = formatter.parse(start.get());
        } else if(start.isPresent() && end.isPresent()) {
            dateStart = formatter.parse(start.get());
            dateEnd = formatter.parse(end.get());
        }      
      
        Optional<List<Object>> s = this.estadoSaudeRepo.getQtdRegistrosByEstadoSaude(dateStart, dateEnd, false);
        return s.get();
    }
    
    @GetMapping("/api/relatorios/registros/bem/qtd")
    public List<Object> getQtdRegistrosBem(
        @RequestParam("start") Optional<String> start,
        @RequestParam("end") Optional<String> end
    ) throws ParseException {      
        LocalDateTime now = LocalDateTime.now(); 
        String dateNowFormat = now.getYear() + "-" + now.getMonthValue()+ "-" + now.getDayOfMonth();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateStart = formatter.parse("2021-01-01");
        Date dateEnd = formatter.parse(dateNowFormat);
        
        if(start.isPresent() && !end.isPresent()){
            dateStart = formatter.parse(start.get());
        } else if(start.isPresent() && end.isPresent()) {
            dateStart = formatter.parse(start.get());
            dateEnd = formatter.parse(end.get());
        }      
      
        Optional<List<Object>> s = this.estadoSaudeRepo.getQtdRegistrosByEstadoSaude(dateStart, dateEnd, true);
        return s.get();
    }
    
    @GetMapping("/api/relatorios/registros/setor/qtd")
    public List<Object> getQtdRegistrosSetor(
        @RequestParam("start") Optional<String> start,
        @RequestParam("end") Optional<String> end
    ) throws ParseException {      
        LocalDateTime now = LocalDateTime.now(); 
        String dateNowFormat = now.getYear() + "-" + now.getMonthValue()+ "-" + now.getDayOfMonth();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateStart = formatter.parse("2021-01-01");
        Date dateEnd = formatter.parse(dateNowFormat);
        
        if(start.isPresent() && !end.isPresent()){
            dateStart = formatter.parse(start.get());
        } else if(start.isPresent() && end.isPresent()) {
            dateStart = formatter.parse(start.get());
            dateEnd = formatter.parse(end.get());
        }      
      
        Optional<List<Object>> s = this.estadoSaudeRepo.getQtdRegistrosBySetor(dateStart, dateEnd);
        return s.get();
    }
    
    @GetMapping("/api/relatorios/registros/doente/setor/qtd")
    public List<Object> getQtdRegistrosNaoBemSetor(
        @RequestParam("start") Optional<String> start,
        @RequestParam("end") Optional<String> end
    ) throws ParseException {      
        LocalDateTime now = LocalDateTime.now(); 
        String dateNowFormat = now.getYear() + "-" + now.getMonthValue()+ "-" + now.getDayOfMonth();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateStart = formatter.parse("2021-01-01");
        Date dateEnd = formatter.parse(dateNowFormat);
        
        if(start.isPresent() && !end.isPresent()){
            dateStart = formatter.parse(start.get());
        } else if(start.isPresent() && end.isPresent()) {
            dateStart = formatter.parse(start.get());
            dateEnd = formatter.parse(end.get());
        }      
      
        Optional<List<Object>> s = this.estadoSaudeRepo.getQtdRegistrosBySetor(dateStart, dateEnd, false);
        return s.get();
    }
}

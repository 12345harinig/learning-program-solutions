package com.employee.controller;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.export.ExcelGenerator;
import com.employee.export.PdfGenerator;
import com.employee.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.mail.MessagingException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmailService emailService;

    // ✅ Create
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // ✅ Read all
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ✅ Update
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> existing = employeeRepository.findById(id);
        if (existing.isPresent()) {
            Employee emp = existing.get();
            emp.setName(updatedEmployee.getName());
            emp.setRole(updatedEmployee.getRole());
            emp.setDepartment(updatedEmployee.getDepartment());
            return employeeRepository.save(emp);
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }

    // ✅ Delete
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted with id " + id;
    }

    // ✅ Debug readable list
    @GetMapping("/debug")
    public String debugAll() {
        List<Employee> list = employeeRepository.findAll();
        if (list.isEmpty()) return "🚫 No employees found in the database.";

        StringBuilder sb = new StringBuilder("📋 EMPLOYEE LIST:\n\n");
        for (Employee e : list) {
            sb.append("ID: ").append(e.getId())
              .append(", Name: ").append(e.getName())
              .append(", Role: ").append(e.getRole())
              .append(", Department: ").append(e.getDepartment().getName())
              .append("\n");
        }
        return sb.toString();
    }

    // ✅ Export PDF
    @GetMapping("/export/pdf")
    public ResponseEntity<InputStreamResource> exportToPdf() {
        List<Employee> employees = employeeRepository.findAll();
        ByteArrayInputStream pdf = PdfGenerator.generate(employees);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=employees.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }

    // ✅ Export Excel
    @GetMapping("/export/excel")
    public ResponseEntity<InputStreamResource> exportToExcel() throws IOException {
        List<Employee> employees = employeeRepository.findAll();
        ByteArrayInputStream excel = ExcelGenerator.generate(employees);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=employees.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(new InputStreamResource(excel));
    }

    // ✅ Send PDF to email
    @GetMapping("/send-pdf")
    public String sendPdfToEmail(@RequestParam String to) {
        try {
            List<Employee> employees = employeeRepository.findAll();
            ByteArrayInputStream pdf = PdfGenerator.generate(employees);

            emailService.sendWithAttachment(to, "Employee Report - PDF",
                    "Here is your report.", pdf, "employees.pdf");

            return "📬 Email with PDF sent to " + to;
        } catch (Exception e) {
            return "❌ Failed to send email: " + e.getMessage();
        }
    }

    // ✅ Send Excel to email
    @GetMapping("/send-excel")
    public String sendExcelToEmail(@RequestParam String to) {
        try {
            List<Employee> employees = employeeRepository.findAll();
            ByteArrayInputStream excel = ExcelGenerator.generate(employees);

            emailService.sendWithAttachment(to, "Employee Report - Excel",
                    "Here is your Excel report.", excel, "employees.xlsx");

            return "📬 Email with Excel sent to " + to;
        } catch (Exception e) {
            return "❌ Failed to send email: " + e.getMessage();
        }
    }
}

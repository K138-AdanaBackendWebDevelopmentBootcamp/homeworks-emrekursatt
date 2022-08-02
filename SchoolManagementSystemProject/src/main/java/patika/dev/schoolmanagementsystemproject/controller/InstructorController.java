package patika.dev.schoolmanagementsystemproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import patika.dev.schoolmanagementsystemproject.service.InstructorService;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    @Autowired //Thanks to the Spring framework IoC, it can be used with different binding methods (such as @Autowired, constructor)
    InstructorService instructorService;

}

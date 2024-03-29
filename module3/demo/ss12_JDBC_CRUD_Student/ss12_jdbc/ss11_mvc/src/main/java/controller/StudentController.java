package controller;

import model.Student;
import service.IStudentService;
import service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StudentController", urlPatterns = {"/student", "/"})
public class StudentController extends HttpServlet {
    //    Mô phỏng DI.
    private IStudentService iStudentService = new StudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                createStudent(request, response);
                break;
            }
            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                iStudentService.deleteById(id);
                response.sendRedirect("/student");

        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        Double grade = Double.valueOf(request.getParameter("grade"));
        if (gender == -1) {
            gender = null;
        }
        Integer id = (int) (Math.random() * 1000);
        Student student = new Student(id, name, dateOfBirth, gender, grade);
        Map<String, String> map = iStudentService.save(student);
        if (map.isEmpty()) {
            response.sendRedirect("/student");
        } else {
            request.setAttribute("error", map);
            request.getRequestDispatcher("create.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                request.getRequestDispatcher("create.jsp").forward(request, response);
            }
            case "delete": {
                int id = Integer.parseInt(request.getParameter("id"));
                Student student = iStudentService.findById(id);
                request.setAttribute("student", student);
                request.getRequestDispatcher("/delete.jsp").forward(request, response);
            break;
            }
            default: {
                List<Student> studentList = this.iStudentService.getAll();
                request.setAttribute("students", studentList);
                request.getRequestDispatcher("/list.jsp").forward(request, response);
            }
        }

    }
}

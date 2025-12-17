
public class StudentController{
    @Autowired
    StudentService ser;

    @PostMapping("/PostStudent")
    public Student postStd(@RequestBody Student st){
        return ser.insertStudent(st);
    }

    @GetMapping("/getAll")
    public List<Student> getAll(){
        return ser.getAllStudent(st);
    }

    @GetMapping("/get/{id}")
    public Optional<Student> get(@PathVariable Long id){
        return ser.getOneStudent(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id,@RequestBody Student newStudent){
        Optional<Student> student=ser.getOneStudent(id);
        if(student.iSPresent()){
            newStudent.setId(id);
            ser.insertStudent(newStudent)
            return "Updated Success";
        }
        return "id not found";
    }

    @DeleteMapping("/del/{id}")
    public String deleteStudent(@PathVariable Long id ){
        Option<Student> student = ser.getOneStudent(id);
        if(student.iSPresent()){
            ser.deleteStudent(id);
            return "Deleted Success";
        }
        return "Id Not Found";
    }
}
package raise.tech.student.management;


import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	private String name = "Momoko";
	private String age = "29";

	private final Map<String,String> studentsProfile = new HashMap<>();{
		studentsProfile.put("Yojiro","39");
		studentsProfile.put("Kuwa","39");
		studentsProfile.put("Takeda","39");
		studentsProfile.put("Satoshi","39");

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/studentsNameAge")
	public String getStudentNameAge(){
		return name + " " + age + "歳";
	}

	@PostMapping("/studentsNameAge")
	public void setStudentsNameAge(String name,String age){
		this.name = name;
		this.age = age;
	}

	@PostMapping("/studentsName")
	public void updateStudentsName(String name){
		this.name = name;

	}

	//Map

	@GetMapping("/studentsProfile")
	public Map<String, String> getStudentsProfile(){
		return studentsProfile;
	}

	@PostMapping("/studentProfile")
	public void updateStudentsProfile(@RequestParam String name,String age){
		//nameが既に存在するかチェック
		if (studentsProfile.containsKey(name)) {
			//存在する場合は上書き
			studentsProfile.put(name, age);
		}else {
			//存在しない場合は新しいエントリに追加
			studentsProfile.put(name,age);

		}
	}

}

@MockBean(HelloRepository.class)
@MockBean(PeopleRepository.class)
@SpringBootTest
public class SomeExampleForAHypotheticalTestInSpring {
    private final HelloService helloService;

    public SomeExampleForAHypotheticalTestInSpring(@Autowired final HelloService helloService) {
        this.helloService = helloService;
    }
}

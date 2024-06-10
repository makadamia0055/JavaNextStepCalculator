import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    public int add(String text){
        List<Integer> parse = parse(text);
        return parse.stream().mapToInt(i->i).sum();
    }

    public List<Integer> parse(String text){
        if(text == null||text.trim().isEmpty()){
            return List.of(0);
        }
        List<String> textList = List.of(text);

        List<Integer> collect = textList.stream()
                .flatMap(this::customParse)
                .flatMap(this::defaultParse)
                .map(str -> {
                    int i = Integer.parseInt(str);
                    if (i < 0) throw new RuntimeException("negative num");
                    return Integer.valueOf(i);
                }).collect(Collectors.toList());

        return collect;

    }

    private Stream<String> defaultParse(String text) {
        String[] split = text.split(",|:");
        return Arrays.stream(split);
    }

    private Stream<String> customParse(String text) {
        Pattern customDelimeterPattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = customDelimeterPattern.matcher(text);
        if(matcher.find()){
            String customDelimeter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimeter);
            return Arrays.stream(tokens);
        }
        return Stream.of(text);
    }

}

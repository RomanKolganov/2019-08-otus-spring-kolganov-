package me.kolganov.dao;

import me.kolganov.domain.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource("classpath:app.properties")
public class QuestionDAOImpl implements QuestionDAO {
    @Value("${file.path_en}")
    private Resource resource_en;
    @Value("${file.path_ru}")
    private Resource resource_ru;

    public List<Question> findByLocale(String locale) {
        List<Question> questions = new ArrayList<>();

        ICsvBeanReader beanReader = null;
        try {
            switch (locale) {
                case "en":
                    beanReader = new CsvBeanReader(new FileReader(resource_en.getFile()), CsvPreference.STANDARD_PREFERENCE);
                    break;
                case "ru":
                    beanReader = new CsvBeanReader(new FileReader(resource_ru.getFile()), CsvPreference.STANDARD_PREFERENCE);
                    break;
                default:
                    beanReader = new CsvBeanReader(new FileReader(resource_ru.getFile()), CsvPreference.STANDARD_PREFERENCE);
            }


            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            Question question;
            while ((question = beanReader.read(Question.class, header, processors)) != null) {
                questions.add(question);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (beanReader != null) {
                try {
                    beanReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return questions;
    }
    private static CellProcessor[] getProcessors(){
        return new CellProcessor[] {
                new ParseInt(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
        };
    }
}

package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> pupilScore = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0D;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
            double scoreAverage = sum / count;
            pupilScore.add(new Label(pupil.name(), scoreAverage));
        }
        return pupilScore;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> scoreBySubject = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + newValue);
            }
            count++;
        }
        for (String subject : map.keySet()) {
            double score = map.get(subject);
            scoreBySubject.add(new Label(subject, score / count));
        }
        return scoreBySubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> students = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = subject.score();
                map.put(pupil.name(), map.getOrDefault(pupil.name(), 0) + score);
            }
        }
        for (String name : map.keySet()) {
            double score = map.get(name);
            students.add(new Label(name, score));
        }
        students.sort(Comparator.naturalOrder());
        return students.get(students.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> scoreBySubject = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), (oldValue, newValue) -> oldValue + newValue);
            }
        }
        for (String subject : map.keySet()) {
            double score = map.get(subject);
            scoreBySubject.add(new Label(subject, score));
        }
        scoreBySubject.sort(Comparator.naturalOrder());
        return scoreBySubject.get(scoreBySubject.size() - 1);
    }
}

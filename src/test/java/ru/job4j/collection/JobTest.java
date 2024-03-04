package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

class JobTest {
    @Test
    public void whenCompareByAscName() {
        Comparator<Job> cmpAscName = new JobAscByName();
        int result = cmpAscName.compare(
                new Job("Learn English", 1),
                new Job("Wash the dishes", 2)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenCompareByDescName() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int result = cmpDescName.compare(
                new Job("Learn English", 1),
                new Job("Wash the dishes", 2)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenCompareByAscPriority() {
        Comparator<Job> cmpAscPriority = new JobAscByPriority();
        int result = cmpAscPriority.compare(
                new Job("Learn English", 1),
                new Job("Wash the dishes", 2)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenCompareDescAscPriority() {
        Comparator<Job> cmpDescPriority = new JobDescByPriority();
        int result = cmpDescPriority.compare(
                new Job("Learn English", 1),
                new Job("Wash the dishes", 2)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenCompareByDescNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Learn English", 1),
                new Job("Learn English", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompareByAscNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Learn English", 1),
                new Job("Learn English", 2)
        );
        assertThat(rsl).isLessThan(0);
    }
}
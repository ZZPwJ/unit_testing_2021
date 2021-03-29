package pl.lodz.p.zzpj.testing.assertj;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static pl.lodz.p.zzpj.testing.assertj.FellowTestFixture.frodo;
import static pl.lodz.p.zzpj.testing.assertj.FellowTestFixture.sauron;

public class FellowshipAssertionTest {

    private Fellowship fellowship = formTheFellowshipOfTheRing();

    @Test
    public void frodoShouldBeIn() {
        assertThat(fellowship).contains(frodo());
    }

    @Test
    public void sauronShouldNotBeIn() {
        assertThat(fellowship).doesNotContain(sauron());
    }

    @Test
    public void shouldFrodoNameBeCorrectAndNotBeASauronAndBeInFellowship() {
        assertThat(frodo().getName()).isEqualToIgnoringCase("frodo");
        assertThat(frodo()).isNotEqualTo(sauron());
        assertThat(frodo()).isIn(fellowship);
    }

    @Test
    public void aragornShouldBeBeforeBoromir() {
        assertThat(fellowship).containsSubsequence(FellowTestFixture.aragorn(),
                FellowTestFixture.boromir());
    }

    @Test
    public void shouldNotContainDuplicatedFellows() {
        assertThat(fellowship).doesNotHaveDuplicates();
    }

    @Test
    public void shouldContainOnlyFellowsWithExpectedNamesInProperOrder() {
        assertThat(fellowship).extracting("name").
                containsExactlyInAnyOrder("Frodo", "Sam", "Merry", "Pippin", "Gandalf",
                        "Legolas", "Gimli", "Aragorn", "Boromir");
    }

    @Test
    public void shouldContainNineFellowsButNoneGiant() {
        assertThat(fellowship).hasSize(9)
                .extracting("race")
                .doesNotContain(Fellow.Race.GIANT);
    }

    @Test
    public void shouldContainTupleForBoromirSamAndLegolas() {
        // Extracting multiple values at once (using tuple to group them)
        // Create tuples with name and race name
        assertThat(fellowship).extracting("name", "race")
                .contains(tuple("Boromir", Fellow.Race.MAN),
                        tuple("Sam", Fellow.Race.HOBBIT),
                        tuple("Legolas", Fellow.Race.ELF));
    }


    @Test
    public void shouldContainsFourHobbits() {
        List<Fellow> hobbitOcc = new ArrayList<>();
        for (Fellow fellow : fellowship) {
            if (fellow.getRace().equals(Fellow.Race.HOBBIT)) {
                hobbitOcc.add(fellow);
            }
        }
        assertThat(hobbitOcc).hasSize(4);
    }


    private Fellowship formTheFellowshipOfTheRing() {
        return new Fellowship(
                frodo(),
                FellowTestFixture.sam(),
                FellowTestFixture.merry(),
                FellowTestFixture.pippin(),
                FellowTestFixture.gandalf(),
                FellowTestFixture.legolas(),
                FellowTestFixture.gimli(),
                FellowTestFixture.aragorn(),
                FellowTestFixture.boromir());
    }
}

package com.aor.numbers;
import spock.lang.Specification
import sun.net.www.content.text.Generic

class FirstSpecification extends Specification {

    def "one plus one should equal to" () {
        expect:
        1 + 1 == 2
    }

    def "two plus two should equal four" () {
        given:
            int left = 2
            int right = 2
        when:
            int result = left + right
        then:
            result == 4
    }

    def "Should be able to remove from list" () {
        given:
            def list = [1, 2, 3, 4]
        when:
            list.remove(0)
        then:
            list == [2, 3, 4]
            // list == [1, 2, 4] --> error
    }

    def "Should get an index out of bounds when removing a nonexistent item" () {
        given:
            def list = [1, 2, 3, 4]
        when:
            list.remove(20)
        then:
            thrown(IndexOutOfBoundsException)
            list.size() == 4
    }

    def "numbers to the power of two" (int a, int b, int c) {
        expect:
            Math.pow(a, b) == c
        where:
            a | b | c
            1 | 2 | 1
            2 | 2 | 4
            3 | 2 | 9
    }

    def "Bug 8726 in Deduplicator" () {
        given:
            def deduplicator = Mock(GenericListDeduplicator)
            def sorter = Mock(GenericListSorter)
        when:
            def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2), sorter)
        then:
            result == null
    }

    def "Using Stubs with Spock" () {
        given:
            def sorter = Mock(GenericListSorter)
            def deduplicator = Mock(GenericListDeduplicator)
            deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2), sorter) >> Arrays.asList(1, 2, 4)
            deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
            deduplicator.deduplicate(_) >>> [Arrays.asList(1, 2, 4), Arrays.asList(6, 7)]
        when:
            def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2), sorter)
        then:
            result == Arrays.asList(1, 2, 4)
    }

    def "Should verify notify was called"() {

        given:
            def notifier = Mock(Notifier)
        when:
            notifier.notify('foo')
        then:
            // 1 * notifier.notify(_)
            1 * notifier.notify('foo')
    }
}
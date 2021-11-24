import spock.lang.Specification

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
}
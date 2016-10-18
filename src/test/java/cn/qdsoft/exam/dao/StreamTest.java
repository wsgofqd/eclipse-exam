package cn.qdsoft.exam.dao;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {

	@Test
	public void iterator() {

		Optional<Integer> p = Stream.iterate(1, m -> m + 1).limit(0).reduce((m, n) -> m + n);

		System.out.println(p.isPresent() ? p.get() : 0);
	}
}

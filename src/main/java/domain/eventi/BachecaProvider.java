package domain.eventi;

import java.util.List;

public interface BachecaProvider {
    List<String> getProposteAfferentiA(String categoria);
}

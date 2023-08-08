package com.multicampus.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("Maria")
public class SampleDAOMariaDBImpl implements SampleDAO {

}

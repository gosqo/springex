package com.multicampus.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("oracleDAO")
public class SampleDAOOracleImpl implements SampleDAO {

}

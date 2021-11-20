package demo

import com.ibm.asyncutil.util.Either


interface Services {
    fun getAll(): Either<Error, List<String>>
}

class ServiceImp: Services {
    override fun getAll(): Either<Error, List<String>> {
        TODO("Not yet implemented")
    }
}
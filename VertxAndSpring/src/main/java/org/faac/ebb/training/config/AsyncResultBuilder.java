package org.faac.ebb.training.config;

import io.vertx.core.AsyncResult;

public class AsyncResultBuilder<T> {

    private T result = null;
    private Throwable exception = null;
    private boolean succeeded = false;

    public AsyncResultBuilder<T> withResult(T result) {
        this.result = result;
        return this;
    }

    public AsyncResultBuilder<T> withCause(Throwable exception) {
        this.exception = exception;
        return this;
    }

    public AsyncResultBuilder<T> withSuccess() {
        this.succeeded = true;
        return this;
    }

    public AsyncResultBuilder<T> withFail() {
        this.succeeded = false;
        return this;
    }


    public AsyncResult<T> build() {
        return new CustomAsyncResult<T>( this.result, this.exception, this.succeeded );
    }


    @SuppressWarnings("hiding")
	class CustomAsyncResult<T> implements AsyncResult<T> {
        private T _result;
        private Throwable _cause;
        private boolean _succeeded;

        public CustomAsyncResult(T result, Throwable cause, boolean succeeded) {
            _result = result;
            _cause = cause;
            _succeeded = succeeded;
        }

        @Override
        public T result() {
            return _result;
        }

        @Override
        public Throwable cause() {
            return _cause;
        }

        @Override
        public boolean succeeded() {
            return _succeeded;
        }

        @Override
        public boolean failed() {
            return !_succeeded;
        }
    }
}

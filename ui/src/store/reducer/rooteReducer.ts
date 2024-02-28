import { combineReducers } from 'redux';
import calculationsReducer from './calculations_reducer';

const rootReducer = combineReducers({
  results: calculationsReducer,
});

export default rootReducer;

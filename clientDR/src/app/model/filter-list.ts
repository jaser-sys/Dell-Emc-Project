import { FilterBy } from './filter-by';

export class FilterList {


    radioVal: string;

    static values: FilterBy[] = [

        {
            name: 'name',
            viewValue: 'Name'
        },
        {
            name: 'size',
            viewValue: 'Size'
        },
        {
            name: 'date',
            viewValue: 'Creation Date'
        }

    ];
}
